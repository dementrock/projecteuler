f = Hash.new { |f, n| f[n] = n < 2 ? n : f[n - 1] + f[n - 2] }
index = 1
while f[index].to_s.length < 1000
  index += 1
end
puts index
