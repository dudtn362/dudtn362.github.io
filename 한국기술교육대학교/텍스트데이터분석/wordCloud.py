import matplotlib.pyplot as plt
from wordcloud import WordCloud

 
font_path = r'D:\wxFormWorkspace\Test\test\NanumFontSetup_TTF_GOTHIC\NanumGothic.ttf'
wordcloud = WordCloud(
    font_path = font_path,
    width = 400,
    height = 400
    )

text = open('test.txt',encoding='utf-8').read()
wordcloud = wordcloud.generate(text)
 
fig = plt.figure(figsize=(12,12))
plt.imshow(wordcloud)
plt.axis("off")
plt.show()
# fig.savefig('wordcloud_without_axisoff.jpg')