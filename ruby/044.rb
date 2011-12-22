def pent n
  n * (3 * n - 1) / 2
end

def int? x
  x.floor == x
end

def pent? x
  int? ((1 + Math.sqrt(1 + 24 * x)) / 6)
end


MAX = 5000

d = pent(MAX)

(1..MAX).each do |i|
  ((i+1)..MAX).each do |j|
    dif = pent(j) - pent(i)
    sum = pent(i) + pent(j)
    if pent? dif and pent? sum
      d = [dif, d].min
    end
  end
end

puts d
