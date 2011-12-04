def cycle_len(n)
  len, remainder, occur = 0, 1, Hash.new(-1)
  while remainder != 0
    occur[remainder] = len 
    len += 1
    remainder = (remainder * 10) % n
    if remainder == 0
      return 0
    end
    if occur[remainder] != -1
      return len - occur[remainder]
    end
  end
end

puts (1...1_000).collect{|x| [cycle_len(x), x]}.max[1]
