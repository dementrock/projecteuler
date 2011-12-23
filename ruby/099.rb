require 'uri'
require 'net/http'

lst = Net::HTTP.get(URI('http://projecteuler.net/project/base_exp.txt')).split.collect {|x| eval('[' + x + ']')}

puts ((0...lst.length).collect {|i| [lst[i][1] * Math.log(lst[i][0]), i + 1]}.max)[1]
