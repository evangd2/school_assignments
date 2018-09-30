#from scipy.interpolate import spline
#from scipy.optimize import curve_fit
import numpy as np
import pylab as pl
import math

a2=math.pi*((0.375/100)**2)
a1=math.pi*((5.4113/100)**2)
heights=list(map(lambda x: int(x)/100,'''
13
12
11
10
9
8
7
6
5
4
3
2
'''.split()))

trial1=list(map(float,'''
2.07
1.51
2.05
1.71
1.95
1.94
2.16
2.49
2.19
2.56
2.46
2.23
2.15
2.23
2.04
2.81
2.29
2.69
2.80
2.87
3.06
3.28
3.00
3.17
2.81
2.86
2.93
4.06
4.06
3.92
4.42
4.10
4.17
5.74
6.64
5.79
'''.split()))

trial2=list(map(float,'''
1.93
2.10
2.21
2.09
1.96
2.12
2.10
2.21
1.90
2.28
2.27
2.37
2.43
2.31
2.46
2.56
2.51
2.66
2.76
2.62
2.77
3.43
3.38
3.43
3.13
3.03
3.39
4.35
4.46
3.66
4.43
4.72
5.06
6.34
6.08
5.67
'''.split()))

avgt1=[(trial1[i]+trial1[i+1]+trial1[i+2])/3 for i in range(0,len(trial1),3)]
avgt2=[(trial2[i]+trial2[i+1]+trial2[i+2])/3 for i in range(0,len(trial2),3)]

avgv1=[0.01/(t-0.5) for t in avgt1]#changed from 0.01
avgv2=[0.01/(t-0.5) for t in avgt2]

avgvsq1=[(a1/a2*v)**2 for v in avgv1]
lin_avgv1=np.polyfit(heights, avgvsq1, 1)
print("lin_avgv1: ", *lin_avgv1)
avgvsq2=[(a1/a2*v)**2 for v in avgv2]
lin_avgv2=np.polyfit(heights, avgvsq2, 1)
print("lin_avgv2: ", *lin_avgv2)

vsq=[2*9.8*h for h in heights]

def changeFig(s, x, y):
	pl.figure(s)
	pl.title(s)
	pl.xlabel(x)
	pl.ylabel(y)

changeFig("(Trial 1) Internal Velocity vs Height", "Height (m)", "Internal Velocity (m/s)")
pl.plot(heights, avgv1)
pl.plot(heights, avgv1, "ko")

changeFig("(Trial 2) Internal Velocity vs Height", "Height (m)", "Internal Velocity (m/s)")
pl.plot(heights, avgv2)
pl.plot(heights, avgv2, "ko")

changeFig("(Trial 1) (Exit Velocity)^2 vs Height", "Height (m)", "(Exit Velocity)^2 ((m/s)^2")
pl.plot(heights,vsq, "b", label="From Bernoulli")
pl.plot(heights, avgvsq1, "m", label="Experimental Data")
pl.plot(heights, avgvsq1, "ko")
pl.plot(heights, np.poly1d(lin_avgv1)(heights), "g",label="Line of Best Fit")

changeFig("(Trial 2) (Exit Velocity)^2 vs Height", "Height (m)", "(Exit Velocity)^2 ((m/s)^2")
pl.plot(heights,vsq, "b", label="From Bernoulli")
pl.plot(heights, avgvsq2, "m", label="Experimental Data")
pl.plot(heights, avgvsq2, "ko")
pl.plot(heights, np.poly1d(lin_avgv2)(heights), "g",label="Line of Best Fit")

pl.legend()
pl.show()
#print(*[((a1*v/a2)**2)/h for v,h in zip(avgv1, heights)])
'''print("T1 Height |\tExp.Time\tTheo.Time\t%Error")
for t,h in zip(avgt1,heights):
	t_=a1*0.01/a2/math.sqrt(2*9.8*h)
	pe=abs(t-t_)/t_*100
	print(("%.2f\t\t%.3f\t\t%.3f\t\t%.1f"%(h,t, t_, pe)))
print("\n")
print("Trial 2 |\tExp.Time\tTheo.Time\t%Error")
for t,h in zip(avgt2,heights):
	t_=a1*0.01/a2/math.sqrt(2*9.8*h)
	pe=abs(t-t_)/t_*100
	print("%.2f\t\t%.3f\t\t%.3f\t\t%.1f"%(h,t, t_, pe))
print("T1 Height |\tVe/Vt\t%Error")
for v,h in zip(avgv1,heights):
	r=math.sqrt(2*9.8*h)/(a1*v/a2)
	pe=abs(r-math.sqrt(2))/math.sqrt(2)*100
	print(("%.2f\t\t%.3f\t\t%.1f"%(h,r,pe)))'''
