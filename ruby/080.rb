def get_sum n

  a = 1 * (10 ** 200)
  b = n * (10 ** 200)
  sqr = n * (10 ** 400)

  while b - a > 10
    mid = (a + b) / 2
    if mid ** 2 < sqr
      a = mid
    else
      b = mid
    end
  end

  (b.to_s[0...100].each_char.collect{|x| x.to_i}.inject(:+))
end

def square? x
  x == (x ** 0.5).to_i ** 2
end

puts ((1..100).collect{|x| if square? x then 0 else get_sum x end}.inject(:+))
