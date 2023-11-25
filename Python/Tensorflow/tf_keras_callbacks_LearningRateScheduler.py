"""
- Learning Rate
* 학습률이 너무 높다면? 걸음이 너무 크기 때문에 최저점을 지나쳐버릴 수 있습니다. 이는 모델의 학습 과정에서 손실이 줄어들지 않고, 심지어 증가할 수도 있다는 것을 의미합니다.
* 학습률이 너무 낮다면? 걸음이 너무 작아서 매우 천천히 이동하게 됩니다. 이는 최적점에 도달하는 데 매우 오랜 시간이 걸릴 수 있으며, 실제로는 최적점에 도달하기 전에 학습이 끝날 수 있습니다.

- Learning Rate 조정하기
* 고정 학습률: 모든 학습 에포크에 걸쳐 학습률을 동일하게 유지합니다. 이는 간단하고 구현하기 쉽지만, 최적의 학습률을 찾기 위해 여러 번의 실험이 필요할 수 있습니다.
* 커스텀 콜백을 사용: 사용자가 직접 학습률의 변화를 정의할 수 있습니다. 예를 들어, 일정한 에포크가 지날 때마다 학습률을 줄이거나, 모델의 성능이 특정 기준에 도달했을 때 학습률을 조절하는 등의 복잡한 로직을 구현할 수 있습니다.
* 옵티마이저 내장 스케줄링: 일부 옵티마이저는 내부적으로 학습률을 조정하는 메커니즘을 가지고 있습니다. 예를 들어, Adam 옵티마이저는 시간에 따라 학습률을 조절할 수 있는 매개변수를 제공합니다.
"""

import tensorflow as tf
import matplotlib.pyplot as plt


# 학습률을 업데이트하는 함수
def scheduler(epoch, lr):
    if epoch < 10:
        return lr
    else:
        return lr * tf.math.exp(-0.1)


# 샘플 모델 생성
model = tf.keras.models.Sequential([
    tf.keras.layers.Dense(1, input_shape=(1,))
])

# 모델 컴파일
model.compile(optimizer='adam', loss='mse')

# LearningRateScheduler 콜백 생성
callback = tf.keras.callbacks.LearningRateScheduler(scheduler)

# 모델 훈련
history = model.fit([1, 2, 3, 4], [1, 2, 3, 4], epochs=20,
                    callbacks=[callback], verbose=0)

# 학습률 변화 시각화
epochs = range(1, 21)
print(epochs)
learning_rates = history.history['lr']
print(learning_rates)
plt.plot(epochs, learning_rates, 'b-', label='Learning rate')  # 파란색 실선으로 표시
plt.title('Learning rate schedule')
plt.xlabel('Epoch')
plt.ylabel('Learning Rate')
plt.legend()
plt.show()
