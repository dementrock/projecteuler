require 'net/http'
require 'uri'
names = Net::HTTP.get URI.parse 'http://projecteuler.net/project/names.txt'
names = names.split(',').collect{|s| s[1...-1]}.sort
puts names.zip(Array(1..names.length)).collect{|s, i| s.each_byte.collect{|x| x - 64}.inject(:+) * i}.inject(:+)
