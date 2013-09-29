package fjab.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExample {

	public static void main(String[] args){
		
		SetExample setExample = new SetExample();
		
		Set<Bean> set = new HashSet<>();
		Bean bean1 = setExample.new Bean(1,2);
		Bean bean2 = setExample.new Bean(3,4);
		Bean bean3 = setExample.new Bean(5,6);
		
		Bean otherBean1 = setExample.new Bean(1,2);
		
		set.add(bean1);
		set.add(bean2);
		set.add(bean3);
		//set.add(otherBean1);
		
		System.out.println("bean1:"+set.contains(bean1));
		System.out.println("otherBean1:"+set.contains(otherBean1));
		
		System.out.println("size:"+set.size());
		
		bean1.setAtt1(3);
		bean1.setAtt2(4);
		
		System.out.println("bean1:"+set.contains(bean1));
		System.out.println("bean2:"+set.contains(bean2));
		
		System.out.println("size:"+set.size());
		
		Iterator<Bean> iterator = set.iterator();
		while(iterator.hasNext()){
			Bean bean = iterator.next();
			System.out.println(bean.toString());
		}
		
	}
	
	
	
	private class Bean{
		
		private int att1;
		private int att2;
		
		Bean(int att1, int att2){
			this.att1=att1;
			this.att2=att2;
		}
		
		private void setAtt1(int att1){
			this.att1=att1;
		}
		
		private void setAtt2(int att2){
			this.att2=att2;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + att1;
			result = prime * result + att2;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Bean other = (Bean) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (att1 != other.att1)
				return false;
			if (att2 != other.att2)
				return false;
			return true;
		}
		private SetExample getOuterType() {
			return SetExample.this;
		}
		
		public String toString(){
			return this.att1+"-"+this.att2;
		}
	}
	
}
