cnt_perm = Hash.new(0)

MAX = 100000

def sorted_perm x
  x.to_s.each_char.collect{|x|x.to_i}.sort.to_s
end

(1..MAX).each do |x|
  cube = x ** 3
  perm = sorted_perm cube
  cnt_perm[perm] += 1
end

(1..MAX).each do |x|
  if cnt_perm[sorted_perm(x**3)] == 5
    puts x**3
    break
  end
end
