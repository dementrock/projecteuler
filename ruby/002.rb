f = Hash.new { |f, n| f[n] = n < 2 ? n : f[n - 1] + f[n - 2] }
sum, index = 0, 1
while f[index] < 4000000
  sum += f[index] if f[index] % 2 == 0
  index += 1
end
puts sum
