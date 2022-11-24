import pandas as pd
import matplotlib.pyplot as plt
from matplotlib import font_manager,rc
 
# 한글 폰트 설정
font_location = 'C:/Windows/Fonts/MALGUNSL.TTF' #맑은고딕
font_name = font_manager.FontProperties(fname=font_location).get_name()
rc('font',family=font_name)


df = pd.read_csv('한국가스공사_생산기지 주변 해수온도 현황_20210831.csv',encoding='cp949')

fig = plt.figure()
fig1 = plt.figure()
fig2 = plt.figure()
fig3 = plt.figure()



axes1=fig.add_subplot(1,1,1)
axes2=fig1.add_subplot(1,1,1)
axes3=fig2.add_subplot(1,1,1)
axes4=fig3.add_subplot(1,1,1)

#히스토그램 그래프 만들기(변수1개)
axes1.hist(df['평택'],bins = 8) #가정의 자녀 수 히스토그램 #bins는 x축 칸(간격)조정
axes2.hist(df['인천'],bins = 8)
axes3.hist(df['통영'],bins = 8)
axes4.hist(df['삼척'],bins = 8)

#제목설정
axes1.set_title('한국가스공사_생산기지(평택) 주변 해수온도')
axes2.set_title('한국가스공사_생산기지 (인천)주변 해수온도')
axes3.set_title('한국가스공사_생산기지(통영) 주변 해수온도')
axes4.set_title('한국가스공사_생산기지(삼척) 주변 해수온도')
#x축라벨링
axes1.set_xlabel('해수온도')
axes2.set_xlabel('해수온도')
axes3.set_xlabel('해수온도')
axes4.set_xlabel('해수온도')
#y축라벨링
axes1.set_ylabel('횟수')
axes2.set_ylabel('횟수')
axes3.set_ylabel('횟수')
axes4.set_ylabel('횟수')
plt.show()