require 'uri'
require 'net/http'

tri = Hash.new(false)

(1..100).each {|x| tri[x * (x + 1) / 2] = true}

puts tri[55]

a = eval('[%s]' % Net::HTTP.get(URI('http://projecteuler.net/project/words.txt')))

puts a.select { |x| tri[x.each_byte.collect { |x| x - ?A + 1 }.inject(:+)]}.count
