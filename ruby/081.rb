require 'uri'
require 'net/http'

matrix = Net::HTTP.get(URI('http://projecteuler.net/project/matrix.txt')).split.collect{|x| eval('[' + x + ']')}

matrix_hash = Hash.new do |hash, key|
  hash[key] = matrix[key[0]][key[1]]
end

min_sum = Hash.new do |hash, key|
  if key == [0, 0]
    hash[key] = matrix_hash[key]
  else
    hash[key] = 1.0/0.0
    if key[0] > 0
      hash[key] = [hash[[key[0] - 1, key[1]]], hash[key]].min
    end
    if key[1] > 0
      hash[key] = [hash[[key[0], key[1] - 1]], hash[key]].min
    end
    hash[key] += matrix_hash[key]
  end
end

puts min_sum[[79, 79]]
