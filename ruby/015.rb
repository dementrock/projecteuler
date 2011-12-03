puts Hash.new{|hash, key| hash[key] = ((key[0] == 0 or key[1] == 0) ? 1 : (hash[[key[0] - 1, key[1]]] + hash[[key[0], key[1] - 1]]))}[[20, 20]]
