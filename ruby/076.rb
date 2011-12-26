dp = Hash.new do |hash, key|
  #f[x, y] = f[x - y, y] + f[x, y - 1]
  x, y = key
  hash[key] = 0
  if x == 0 or y == 1
    hash[key] = 1
  else
    if x >= y
      hash[key] += hash[[x - y, y]]
    end
    hash[key] += hash[[x, y - 1]]
  end
end


puts dp[[100, 99]]
