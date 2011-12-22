require 'uri'
require 'net/http'

map = Hash.new(0)

Net::HTTP.get(URI('http://projecteuler.net/project/keylog.txt')).each_line do |line|
  a, b, c = line[0..0].to_i, line[1..1].to_i, line[2..2].to_i
  map[[a, b]] = map[[b, c]] = 1
end

puts map.inspect
