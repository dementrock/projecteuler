require 'utils'

Integer.sieve(1_000_000)

class Integer
  def trunc?
    x = self.to_i
    if x < 10 or not x.prime?
      return false
    end
    y, z = x, x
    (x.to_s.length - 1).times do
      y = y.to_s[1..-1].to_i
      z = z.to_s[0...-1].to_i
      if not y.prime? or not z.prime?
        return false
      end
    end
    return true
  end
end

ans = []
(1..1.0/0.0).each do |x|
  if x.trunc?
    ans.push(x)
    if ans.length == 11
      break
    end
  end
end

puts ans.inject(:+)
  
