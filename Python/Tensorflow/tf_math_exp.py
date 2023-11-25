import tensorflow as tf

print('1. 기본')
x = tf.constant(2.0)
print(tf.math.exp(x))  # e^x

print('2. 배열을 args로 사용')
x = tf.constant([2.0, 8.0])
print(tf.math.exp(x))
