package danyu.cciv;

import java.util.ArrayList;

import danyu.alg.util.ArrayHelper;

public class chap01 {

	public class q0107{
		
		public Integer[][] removeZeros(Integer a[][]){
			int row=a.length, col=a[0].length;
			
			//record cols and rows to be set as zeros
			ArrayList<Integer> rowsTo0=new ArrayList<Integer>(),
					colsTo0=new ArrayList<Integer>();
			
			//find out rows and cols to be set as zeros
			//n^2
			for(int i=0;i<row;i++){
				for(int j=0;j<col;j++){
					if(a[i][j]==0){
						if(rowsTo0.indexOf(i)==-1) rowsTo0.add(i);
						if(colsTo0.indexOf(j)==-1) colsTo0.add(j);
						}
				}
			}
			
			//set zeros
			for (int i=0;i<rowsTo0.size();i++){
				for (int j=0;j<col;j++) a[rowsTo0.get(i)][j]=0;
			}
			
			for (int i=0;i<row;i++){
				for (int j=0;j<colsTo0.size();j++) a[i][colsTo0.get(j)]=0;
			}
			return a;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[][] a={
				{1,2,3,4},
				{4,0,0,7},
				{7,0,9,10},
				{7,8,9,10}
				};
		ArrayHelper.printMatrix(a);
		chap01 testCase=new chap01();
		ArrayHelper.printMatrix((new chap01().new q0107()).removeZeros(a));
		
	}

}
