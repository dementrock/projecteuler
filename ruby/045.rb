def int? x
  x.floor == x
end

def tri? x
  int? ((-1 + Math.sqrt(1 + 8 * x)) / 2)
end

def pen? x
  int? ((1 + Math.sqrt(1 + 24 * x)) / 6)
end

(1..1.0/0.0).each do |i|
  x = i * (2 * i - 1)
  if x > 40755 and tri? x and pen? x
    puts x
    break
  end
end
