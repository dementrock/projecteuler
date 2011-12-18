a = Hash.new do |f, n|
  val, lst = n
  if val == 0
    f[n] = 1
  elsif val < 0 or lst.empty?
    f[n] = 0
  else
    cur = lst[-1]
    f[n] = f[[val, lst[0...-1]]] + f[[val - cur, lst]]
  end
end

puts a[[200, [1, 2, 5, 10, 20, 50, 100, 200]]]
