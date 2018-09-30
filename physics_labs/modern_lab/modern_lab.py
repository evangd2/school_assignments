#zois don't worry I'm using matplotlib for physics
import pylab as pl
#import numpy as np
from scipy.optimize import curve_fit
from numpy import linspace
def changeFig(s, x, y):
	pl.figure(s)
	pl.title(s)
	pl.xlabel(x)
	pl.ylabel(y)
def voltage_eq(x,a,b):
	return a*x+b
#datasets
wavelengths = [630E-9, 590E-9, 570E-9, 470E-9] #red, yellow, green, blue
frequencies = [3E8/x for x in wavelengths]
obs1_v=[1.59, 1.67, 1.77, 2.30]
obs2_v=[1.59, 1.68, 1.76, 2.3]
a1,b1=curve_fit(voltage_eq, frequencies, obs1_v)[0]
a2,b2=curve_fit(voltage_eq, frequencies, obs2_v)[0]
freq_space=linspace(min(frequencies),max(frequencies), 50)
#line2=np.polyfit(frequencies, obs2_v, 1)
print("Observer 1 Regression:",a1,b1)
print("Observer 2 Regression:",a2,b2)
c=6.626E-34/1.6E-19
print("Observer 1 Error:", abs(a1-c)/c)
print("Observer 2 Error:",abs(a2-c)/c)
def graph():
	changeFig("Observer 1: Stopping Voltage (V) vs. Light Frequency (Hz)", "Light Frequency (Hz)", "Stopping Voltage (V)")
	pl.plot(frequencies, obs1_v, "ks", label="Data")
	pl.plot(freq_space, [voltage_eq(x,a1,b1) for x in freq_space], "m--", label="Estimated Voltage (Obs1)= %.3ex+%.3e"%(a1,b1))
	pl.legend()
	changeFig("Observer 2: Stopping Voltage (V) vs. Light Frequency (Hz)", "Light Frequency (Hz)", "Stopping Voltage (V)")
	pl.plot(frequencies, obs2_v, "ks", label="Data")
	pl.plot(freq_space, [voltage_eq(x,a2,b2) for x in freq_space], "m--", label="Estimated Voltage (Obs2)= %.3ex+%.3e"%(a2,b2))
	pl.legend()
	pl.show()
#graph()