from rdflib.graph import ConjunctiveGraph as Graph
from rdflib.store import Store
from rdflib.plugin import get as plugin
from rdflib.term import URIRef

import glob   
import sys
import BridgePattern



def parseBridgePattern(file):
    f=open(file, 'r')  
    lines = f.readlines() 
    
    id = ""
    part = ""
    query = []
    entities = []
    sen_var_ent = []
    triples = []
    
    status = 'query'
    for line in lines : 
        #sys.stdout.write(line) 
        if "coverage" in line :
            status = "coverage"
            continue
        if "entities" in line :
            status = "entities"
            continue
        if "min_cov" in line :
            status = "min_cov"
            continue
        if "number_of_kernels" in line :
            status = "number_of_kernels"
            continue
        if "part" in line :
            part = line
            status = "part"
            continue
        if "sen_var_ent" in line :
            status = "sen_var_ent"
            continue
        if "triples" in line :
            status = "triples"
            continue
        
        if status == 'query' :
            query.append(str(line))
        if status == 'entities' :
            entities.append(str(line))
        if status == 'sen_var_ent' :
            sen_var_ent.append(str(line))
        if status == 'triples' :
            triples.append(str(line))
        
    
    bridgepattern = BridgePattern.makeBridgePattern(id, part, query, entities, sen_var_ent, triples)
    
    f.close() 
    
    return bridgepattern



def sendBridgePatternToVirtuoso(bridgePattern):
    Virtuoso = plugin("Virtuoso", Store)
    store = Virtuoso("DSN=VOS;UID=dba;PWD=Password1;WideAsUTF16=Y")
    default_graph_uri = "http://people.aifb.kit.edu/mu2771/step/"

    graph = Graph(store,identifier = URIRef(default_graph_uri))
    graph.add((URIRef("http://llisa.dlsi.uji.es/productset#0g9x91t"),URIRef("http://xmlns.com/foaf/0.1/nick"),Literal("The Car")))
    store.commit()
    
    return None

#path = '/home/sba/Documents/1_STEP/AP5/Bridge_Pattern/rdf-grounded-strings-testset/*
path = '/home/sba/Documents/1_STEP/AP5/Bridge_Pattern/en-step5-backup/*'  
virtuoso_server = 'http://scc' 
files=glob.glob(path)   

counter = 0
for file in files:     
    bridgepattern = parseBridgePattern( file )
    sendBridgePatternToVirtuoso( bridgepattern )
    
    counter = counter + 1 
    
    
sys.stdout.write(str(counter))


