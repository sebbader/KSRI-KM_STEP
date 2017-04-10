class BridgePattern(object):
    id = ""
    part = ""
    query = []
    
    entities = []
    sen_var_ent = []
    triples = []

    # The class "constructor" - It's actually an initializer 
    def __init__(self, id, part, query, entities, sen_var_ent, triples):
        self.id = id
        self.part = part
        self.query = query
        
        self.entities = entities
        self.sen_var_ent = sen_var_ent
        self.triples = triples

def makeBridgePattern(id, part, query, entities, sen_var_ent, triples):
    bridgePattern = BridgePattern(id, part, query, entities, sen_var_ent, triples)
    return bridgePattern