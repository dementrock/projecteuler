cnt = Hash.new(0)

(1..500).each do |a|
  (a+1..500).each do |b|
    c = Math.sqrt(a*a + b*b)
    if c == c.floor and a + b + c.floor <= 1000
      cnt[a + b + c.floor] += 1
    end
  end
end

puts (1..1000).collect { |x| [cnt[x], x] }.max
