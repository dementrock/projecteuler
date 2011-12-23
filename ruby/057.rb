require 'rational'

def get_next x
  1 + 1 / (1 + x)
end

now = 1.to_r
cnt = 0

1000.times do
  now = get_next now
  if now.numerator.to_s.length > now.denominator.to_s.length
    cnt += 1
  end
end

puts cnt
