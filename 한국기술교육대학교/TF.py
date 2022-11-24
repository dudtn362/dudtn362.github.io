# 텐서플로우 수입
import tensorflow as tf
import cv2
import numpy as np
import matplotlib.pyplot as plt

# MNIST 손글씨 데이터 package 수입
mnist = tf.keras.datasets.mnist

# MNIST 4분할 데이터 불러오기
(X_train, Y_train), (X_test,Y_test) = mnist.load_data()
print('학습용 입력데이터 모양 : ', X_train.shape)
print('학습용 출력데이터 모양 : ', Y_train.shape)
print('평가용 입력데이터 모양 : ', X_test.shape)
print('평가용 출력데이터 모양 : ', Y_test.shape)

# 이미지 데이터[0,1] 스케일링
X_train = X_train / 255.0
X_test = X_test / 255.0

# 인공신경망 구현
model = tf.keras.models.Sequential()
layers = tf.keras.layers

model.add(layers.Flatten(input_shape=(28,28)))
model.add(layers.Dense(128,activation='relu'))
model.add(layers.Dropout(0.2))
model.add(layers.Dense(10, activation='softmax'))


# 인공신경망 학습 환경 설정
model.compile(optimizer='adam',
              loss='sparse_categorical_crossentropy',
              metrics=['accuracy'])
# 인공신경망 학습
model.fit(X_train, Y_train,epochs=5)
# 인공신경망 평가
model.evaluate(X_test,Y_test)


image = cv2.imread("number_3.jpg", cv2.IMREAD_GRAYSCALE) # 흑백 이미지로 로드
plt.imshow(image, cmap="gray"), plt.axis("off") # 이미지를 출력

# 이미지 데이터 전처리
img = np.resize(image, (1, 784))
img = img.reshape(1,28,28)
# 인공신경망 예측
test_data = ((np.array(img) / 255) - 1) * -1
pred = model.predict(test_data)
answer = np.argmax(pred,axis=1)
print("=============================================================")
print('\n인공신경망 추측 결과 (원본):',pred)
print("=================================================================")
print('인공신경망 추측 결과 (해석):',answer)
plt.show()
