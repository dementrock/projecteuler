a = Hash.new{|hash, key| hash[key] = 1 + (key == 1 ? 0 : ((key % 2 == 0) ? hash[key / 2] : hash[3 * key + 1]))}
puts (1..1_000_000).collect{|i| [a[i], i]}.max[1]
