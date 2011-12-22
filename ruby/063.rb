"""
Must satisfy:
10^(n-1) <= x^n < 10^n
"""

ans = 0

(1..9).each do |x|
  (1..(1.0/0.0)).each do |n|
    if x ** n < 10 ** (n - 1)
      break
    end
    if (x ** n).to_s.length == n
      ans += 1
    end
  end
end

puts ans
