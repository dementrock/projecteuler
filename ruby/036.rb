def palindrome?(x)
  x.to_s == x.to_s.reverse
end

class Integer
  def tobase(base)
    s = ""
    cur = self.to_i
    while cur > 0
      s += (cur % base).to_s
      cur = cur / base
    end
    if s.empty?
      s = "0"
    end
    return s.reverse
  end
end

#puts 100.tobase(2)
puts (1...1_000_000).select { |x| palindrome? (x.to_s) and palindrome?(x.tobase(2)) }.inject(:+)
