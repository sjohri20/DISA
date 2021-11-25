
filename=raw_input()
f=open(filename,'r')

lines=f.readlines()
s=""
nf=open("output1.txt","w")

for l in lines:
	s=s+l.strip()+","

for x in s:
	nf.write(x)

f.close()
nf.close()



