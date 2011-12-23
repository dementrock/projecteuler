require 'uri'
require 'net/http'

crypt = eval('[%s]' % Net::HTTP.get(URI('http://projecteuler.net/project/cipher1.txt')))

chars = (97..122)

def plain? x
  (97..122).include? x or (65..90).include? x
end

chars.each do |a|
  chars.each do |b|
    chars.each do |c|
      key = [a, b, c]
      decrypted = ""
      (0...crypt.length).each do |i|
        decrypted += (key[i % 3] ^ crypt[i]).chr
      end
      if decrypted.split.collect {|x| x.length}.max < 15
        puts [a, b, c].inspect
        puts decrypted
        puts decrypted.each_byte.inject(:+)
      end
    end
  end
end
