n = 12000
a, b, c, d = 0, 1, 1, n

cnt = 0

while c <= n
  k = (n + b) / d
  a, b, c, d = c, d, k * c - a, k * d - b
  cnt += 1
  if a == 1 and b == 3
    start_id = cnt
  elsif a == 1 and b == 2
    end_id = cnt
    puts end_id - start_id - 1
    break
  end
end
