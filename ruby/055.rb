require 'utils'

class Integer
  def lychrel?
    x = self.to_i
    50.times do
      x = x + (x.to_s.reverse.to_i)
      if x.palindrome?
        return false
      end
    end
    true
  end
end

puts (1..10000).select{ |x| x.lychrel? }.count
