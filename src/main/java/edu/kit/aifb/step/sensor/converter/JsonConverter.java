package edu.kit.aifb.step.sensor.converter;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.jena.atlas.json.JsonArray;
import org.apache.jena.atlas.json.JsonObject;
import org.apache.jena.atlas.json.JsonValue;
import org.apache.jena.datatypes.RDFDatatype;
import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.graph.Node;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.graph.Triple;
import org.apache.jena.graph.impl.LiteralLabel;
import org.apache.jena.graph.impl.LiteralLabelFactory;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDFS;

import edu.kit.aifb.step.Config;

public class JsonConverter {

	private Config config;

	public JsonConverter(Config config) {
		this.config = config;
	}

	public Model convertToRDF(JsonObject data) {	

		Model model = ModelFactory.createDefaultModel();
		String subjURL = config.getDevice().toString();

		// meta data part
		model.add(model.createResource(subjURL), 
				model.createProperty("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"),
				model.createResource("http://purl.oclc.org/NET/ssnx/ssn#SensingDevice") ) ;



		// actual data part
		if (data.isArray()) {

			Collection<JsonValue> array = data.values();
			int counter = 1;

			for (JsonValue value : array) {
				JsonArray jsonArray = value.getAsArray();

				for (JsonValue jsonValue : jsonArray) {
					JsonObject jsonObject = jsonValue.getAsObject();
					Resource subj = model.createResource(subjURL);
					Property pred = model.createProperty(jsonObject.keys().iterator().next().toString());
					try {
						Resource obj = model.createResource(jsonObject.get(jsonObject.keys().iterator().next()).toString());
						model.add(subj, pred, obj );
					} catch (Exception e) {
						Literal obj = model.createLiteral(jsonObject.get(jsonObject.keys().iterator().next()).toString());
						model.add(subj, pred, obj );
					}

				}
			}

		} else {
			
			// meta information about sensing event (=> ssn:SensorOutput)
			String sensorOutputEntity = config.getNamespace() +
					"SensorOutput-" +
//					(String) deviceCharacteristics.get("id") + 
//					"-" +
					Calendar.getInstance().getTimeInMillis();

			model.add( model.createStatement(model.createResource(sensorOutputEntity),
					model.createProperty("http://purl.oclc.org/NET/ssnx/ssn#isProducedBy"), 
					model.createResource(subjURL) ) );
			
			model.add( model.createStatement(model.createResource(sensorOutputEntity),
					model.createProperty("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), 
					model.createResource("http://purl.oclc.org/NET/ssnx/ssn#SensorOutput") ) );
			

			// meta information about observation (=> ssn:ObeservationValue)
			int counter = 1;
			String observationValueEntity = config.getNamespace() +
					"ObservationValue_" +
					counter + "_" +
					config.getMAC().replaceAll(":", "-") + 
					"_" +
					Calendar.getInstance().getTimeInMillis();

			model.add( model.createStatement(model.createResource(sensorOutputEntity),
					model.createProperty("http://purl.oclc.org/NET/ssnx/ssn#hasValue"), 
					model.createResource(observationValueEntity) ) );
			
			model.add( model.createStatement(model.createResource(observationValueEntity),
					model.createProperty("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), 
					model.createResource("http://purl.oclc.org/NET/ssnx/ssn#ObservationValue") ) );
			
			// data handling
			String key = data.keys().iterator().next().toString();
			String object = data.get(data.keys().iterator().next()).toString();
			model.add( getAccordingModel(observationValueEntity, key, object) );
			
		}

		return model;
	}

	
	private Model getAccordingModel(String subject, String key, String data) {
		Model triples = ModelFactory.createDefaultModel();
		
		if (key.matches(".*(H|h)umidity.*")) {
			
			triples.add( triples.createStatement(triples.createResource(subject),
					triples.createProperty("http://qudt.org/schema/qudt#value"),
					//NodeFactory.createLiteral(data.split(", ")[1].replaceAll("\\)", "").replaceAll("\\\"", ""), XSDDatatype.XSDdouble) ) );
					triples.createLiteral(data.split(", ")[1].replaceAll("\\)", "").replaceAll("\\\"", "")) ) );

			triples.add( triples.createStatement(triples.createResource(subject),
					triples.createProperty("http://qudt.org/schema/qudt#unit"),
					triples.createLiteral("http://aifb.kit.edu/step/unit#RelativeHumidity") ) );
			
		} else if (key.matches(".*(L|l)ight.*")) {
			
			triples.add( triples.createStatement(triples.createResource(subject),
					triples.createProperty("http://qudt.org/schema/qudt#value"),
					//NodeFactory.createLiteral(data.replace("\"", ""), XSDDatatype.XSDdouble) ) );
					triples.createLiteral(data.replace("\"", "") ) ) );

			triples.add( triples.createStatement(triples.createResource(subject),
					triples.createProperty("http://qudt.org/schema/qudt#unit"),
					triples.createLiteral("http://qudt.org/vocab/unit#Lux") ) );
			
		} else if (key.matches(".*(B|b)arometer.*")) {
			
			triples.add( triples.createStatement(triples.createResource(subject),
					triples.createProperty("http://qudt.org/schema/qudt#value"),
					//NodeFactory.createLiteral(data.split(", ")[1].replaceAll("\\)", "").replaceAll("\\\"", ""), XSDDatatype.XSDdouble) ) );
					triples.createLiteral(data.split(", ")[1].replaceAll("\\)", "").replaceAll("\\\"", "") ) ) );

			triples.add( triples.createStatement(triples.createResource(subject),
					triples.createProperty("http://qudt.org/schema/qudt#unit"),
					triples.createLiteral("http://qudt.org/vocab/unit#AtmosphereStandard")  ) );
			
		} else if (key.matches(".*(T|t)emp.*")) {
			
			triples.add( triples.createStatement(triples.createResource(subject),
					triples.createProperty("http://qudt.org/schema/qudt#value"),
					//NodeFactory.createLiteral(data.split(", ")[0].replaceAll("\\)", "").replaceAll("\\(", "").replaceAll("\\\"", ""), XSDDatatype.XSDdouble) ) );
					triples.createLiteral(data.split(", ")[0].replaceAll("\\)", "").replaceAll("\\(", "").replaceAll("\\\"", "") ) ) );

			triples.add( triples.createStatement(triples.createResource(subject),
					triples.createProperty("http://qudt.org/schema/qudt#unit"),
					triples.createLiteral("http://qudt.org/vocab/unit#DegreeCelsius")  ) );
			
		} else {
			
			
		}
		
		// add a time stamp
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
		String dateTime = fmt.format(cal.getTime());
		triples.add( triples.createStatement(triples.createResource(subject),
				triples.createProperty("http://aifb.kit.edu/step/time"),
				//NodeFactory.createLiteral( dateTime, XSDDatatype.XSDdateTime ) ) );
				triples.createLiteral( dateTime ) ) );
		
		
		return triples;
	}

	public static boolean isValidURL(String object) {
		try {
			new URL(object);
		} catch (Exception e) {
			return false;
		}
		return true;
	}


}
