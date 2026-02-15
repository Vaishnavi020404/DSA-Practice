import numpy as np
import matplotlib.pyplot as plt
import tensorflow as tf
from tensorflow.keras.layers import Input, Dense
from tensorflow.keras.models import Model
from tensorflow.keras.datasets import mnist

(x_train, _), (x_test, _) = mnist.load_data()

x_train = x_train.astype("float32") / 255.0
x_test = x_test.astype("float32") / 255.0

x_train = x_train.reshape(len(x_train), 784)
x_test = x_test.reshape(len(x_test), 784)

input_img = Input(shape=(784,))

encoded = Dense(128, activation="relu")(input_img)
encoded = Dense(64, activation="relu")(encoded)
latent = Dense(32, activation="relu")(encoded)

decoded = Dense(64, activation="relu")(latent)
decoded = Dense(128, activation="relu")(decoded)
output = Dense(784, activation="sigmoid")(decoded)

autoencoder = Model(input_img, output)

autoencoder.compile(optimizer="adam", loss="mse")

autoencoder.summary()

autoencoder.fit(
    x_train,
    x_train,
    epochs=20,
    batch_size=256,
    shuffle=True,
    validation_data=(x_test, x_test)
)

reconstructed_imgs = autoencoder.predict(x_test)

n = 15
plt.figure(figsize=(20, 4))

for i in range(n):
    ax = plt.subplot(2, n, i + 1)
    plt.imshow(x_test[i].reshape(28, 28), cmap="gray")
    plt.axis("off")

    ax = plt.subplot(2, n, i + 1 + n)
    plt.imshow(reconstructed_imgs[i].reshape(28, 28), cmap="gray")
    plt.axis("off")

plt.show()


# Exercise 1:
def build_autoencoder(latent_dim):
    input_img = Input(shape=(784,))
    encoded = Dense(128, activation="relu")(input_img)
    encoded = Dense(64, activation="relu")(encoded)
    latent = Dense(latent_dim, activation="relu")(encoded)

    decoded = Dense(64, activation="relu")(latent)
    decoded = Dense(128, activation="relu")(decoded)
    output = Dense(784, activation="sigmoid")(decoded)

    model = Model(input_img, output)
    model.compile(optimizer="adam", loss="mse")
    return model

latent_sizes = [8, 16, 32, 64]

for l in latent_sizes:
    print("Training for latent size:", l)
    model = build_autoencoder(l)
    #printing validation loss
    history = model.fit(
    x_train, x_train,
    epochs=10,
    batch_size=256,
    shuffle=True,
    validation_data=(x_test, x_test)
)

final_val_loss = history.history['val_loss'][-1]
print("Final validation loss for latent size", l, ":", final_val_loss)

#showing reconstructed images
reconstructed = model.predict(x_test)

n = 5
plt.figure(figsize=(10, 4))
for i in range(n):
    plt.subplot(2, n, i + 1)
    plt.imshow(x_test[i].reshape(28, 28), cmap="gray")
    plt.axis("off")

    plt.subplot(2, n, i + 1 + n)
    plt.imshow(reconstructed[i].reshape(28, 28), cmap="gray")
    plt.axis("off")

plt.suptitle(f"Latent size = {l}")
plt.show()

print("Smaller latent space(8,16) increases compression but reduces reconstruction fidelity.Larger latent space(32) improves reconstruction quality at the cost of reduced compression.Hence, there is a trade-off between compression efficiency and reconstruction accuracy.(Medium->32)")


# EXERCISE 2:
input_img = Input(shape=(784,))


encoded = Dense(256, activation="relu")(input_img)
encoded = Dense(128, activation="relu")(encoded)
encoded = Dense(64, activation="relu")(encoded)
latent = Dense(32, activation="relu")(encoded)

decoded = Dense(64, activation="relu")(latent)
decoded = Dense(128, activation="relu")(decoded)
decoded = Dense(256, activation="relu")(decoded)
output = Dense(784, activation="sigmoid")(decoded)

deep_autoencoder = Model(input_img, output)

deep_autoencoder.compile(optimizer="adam", loss="mse")

history = deep_autoencoder.fit(
    x_train, x_train,
    epochs=20,
    batch_size=256,
    shuffle=True,
    validation_data=(x_test, x_test)
)

final_val_loss = history.history['val_loss'][-1]
print("Final validation loss (deep autoencoder):", final_val_loss)

reconstructed = deep_autoencoder.predict(x_test)

n = 5
plt.figure(figsize=(10, 4))

for i in range(n):
    plt.subplot(2, n, i + 1)
    plt.imshow(x_test[i].reshape(28, 28), cmap="gray")
    plt.title("Original")
    plt.axis("off")

    plt.subplot(2, n, i + 1 + n)
    plt.imshow(reconstructed[i].reshape(28, 28), cmap="gray")
    plt.title("Reconstructed")
    plt.axis("off")

plt.suptitle("Deep Autoencoder (Latent size = 32)")
plt.show()

print("Adding more hidden layers increases the model’s ability to learn complex image structures.However, deeper networks require more training time and have a higher risk of overfitting.Therefore, an optimal depth is required to balance performance and generalization.")




