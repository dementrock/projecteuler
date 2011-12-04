def get_permutation(i, n, used)
  if n < 0
    return []
  end
  n_fractal = n > 0 ? ((1..n).inject(:*)) : 1
  cur_digit = 0
  while i > n_fractal or used[cur_digit]
    if not used[cur_digit]
      i -= n_fractal
    end
    cur_digit += 1
  end
  used[cur_digit] = true
  return [cur_digit] + get_permutation(i, n - 1, used)
end
puts get_permutation(1_000_000, 9, Hash.new(false)).join('')
