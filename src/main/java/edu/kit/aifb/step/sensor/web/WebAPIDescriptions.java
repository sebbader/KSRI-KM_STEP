package edu.kit.aifb.step.sensor.web;

import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.RDFReader;
import org.apache.jena.rdf.model.RDFWriter;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDF;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WebAPIDescriptions {
	Model model;
	
	public WebAPIDescriptions() {
		model = ModelFactory.createDefaultModel();
		model.setNsPrefix("", "http://aifb.kit.edu/step");
		
		// this entity
		Resource _a = model.createResource("");
		_a.addProperty(RDF.type, model.createResource("http://aifb.kit.edu/step/vocab#Sensor"));
		_a.addProperty(RDF.type, model.createResource("http://www.w3.org/2005/Incubator/ssn/ssnx/ssn#SensingDevice"));
	}
	
	
	public String getXMLData() {
		
		//RDFReader reader = model.getReader();
		
		//TODO: Bug: relative URIs not supported in this configuration
		RDFWriter writer = model.getWriter("RDF/XML");
		writer.setProperty("relativeURIs", "same-document");
		StringWriter out = new StringWriter();
		model.write(out, "RDF/XML");
		
		return out.toString();
	}
	

	public String getHTML() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("html");
			
			Element head = doc.createElement("head");
			rootElement.appendChild(head);
			
			Element title = doc.createElement("title");
			title.setTextContent("CC2650 - B4:...");
			head.appendChild(title);

			Element body = doc.createElement("body");
			//TODO: Bug in XML+RDF output: relative URI <> not supported in XML
			//body.setTextContent(getXMLData());
			body.setTextContent(getTurtle());
			
			rootElement.appendChild(body);
			
			doc.appendChild(rootElement);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(doc), new StreamResult(writer));
			String output = writer.getBuffer().toString().replaceAll("\n|\r", "");
			
			return output;
		} catch (ParserConfigurationException | DOMException | TransformerException e) {
			e.printStackTrace();
			
			return "<html>401</html>";
		}
	}

	public String getTurtle() {
		StringWriter out = new StringWriter();
		model.write(out, "TURTLE");
		
		return out.toString();
	}
	
	public String getNtriples() {
		StringWriter out = new StringWriter();
		model.write(out, "N-TRIPLE");
		
		return out.toString();
	}


	public String getJSON() {
		StringWriter out = new StringWriter();
		model.write(out, "RDF/JSON");
		
		return out.toString();
	}

	public String getJSONLD() {
		StringWriter out = new StringWriter();
		model.write(out, "JSON-LD");
		
		return out.toString();
	}

}
