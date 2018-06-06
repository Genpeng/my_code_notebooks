
public class TestArray {
	public static void main(String[] args) {
		/**
		 * 动态初始化
		 */
//		Date[] arr = new Date[3];
//		arr[0] = new Date(2014, 01, 01);
//		arr[1] = new Date(2015, 01, 01);
//		arr[2] = new Date(2016, 01, 01);

		/**
		 * 静态初始化
		 */
//		Date[] arr = {new Date(2014, 01, 01), 
//					  new Date(2015, 01, 01), 
//					  new Date(2016, 01, 01)};

		/**
		 * 数组元素的默认初始化
		 * 数组是引用类型，它的元素相当于类的成员变量，因此数组分配空间后，
		 * 每个元素也被按照成员变量的规则被隐式初始化。
		 */
//		int[] arr1 = new int[3];
//		Date[] arr2 = new Date[3];
//		System.out.println(arr1[0]);
//		System.out.println(arr2[2]);

		/**
		 * 从命令行不按顺序输入1~9，将其存入一个整型数组中
		 */
//		int[] arr = new int[args.length];
//		for (int i=0; i<arr.length; i++) {
//			arr[i] = Integer.parseInt(args[i]); // 基本类型的包装类
//		}

		/**
		 * 对一个整型数组进行排序
		 */
//		int[] a = new int[] {2, 5, 8, 4, 1, 3, 7, 9, 6};
//		print(a);

		// 选择排序的基本版本
//		a = basicSelectionSort(a);
//		print(a);
		
		// 选择排序的改进版本
//		a = improvedSelectionSort(a);
//		print(a);

		// 冒泡排序
//		a = bubbleSort(a);
//		print(a);

		// 数三退一（智力题），来自马士兵《Java基础》第5章数组练习8
		/**
		 * 用一个布尔型数组去模拟围成的圈，其中，true表示这个人还在圈内，false则表示这个人已经
		 * 退出。接着用三个变量分别保存当前还剩的人数、当前的数字以及数组的索引。
		 */
//		int index = count3Quit1(1);
//		System.out.println(index);

		// 二分法（Binary Search）
//		int[] a = {1, 3, 6, 8, 9, 10, 12, 18, 20, 34}; // 静态初始化
//		int n = 12;
//		System.out.println(binarySearch(a, n));

		/**
		 * 二维数组的初始化方法有两种：
		 * 1. 静态初始化
		 * 2. 动态初始化
		 */
		// 静态初始化
//		int[][] a = {{1, 2}, {2, 3}, {3, 4, 5}};
//		print(a);

		// 动态初始化
//		int[][] a = new int[2][3];
//		int[][] a = new int[3][];
//		a[0] = new int[2];
//		a[1] = new int[2];
//		a[3] = new int[3];
	}

	/**
	 * 选择排序的基本版本
	 */
	public static int[] basicSelectionSort(int[] arr) {
		for (int i=0; i<arr.length-1; i++) {
			for (int j=i+1; j<arr.length; j++) {
				if (arr[j] < arr[i]) {
					int temp;
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
	
	/**
	 * 选择排序的改进版
	 */
	public static int[] improvedSelectionSort(int[] arr) {
		int k, temp;
		for (int i=0; i<arr.length-1; i++) {
			k = i;
			for (int j=k+1; j<arr.length; j++) {
				if (arr[j] < arr[k]) {
					k = j;
				}
			}

			if (k != i) {
				temp = arr[i];
				arr[i] = arr[k];
				arr[k] = temp;
			}
		}
		return arr;
	}

	/**
	 * 冒泡排序
	 * 思想：较大的数沉下去，较小的数浮上来。
	 */
	public static int[] bubbleSort(int[] arr) {
		int temp;
		for (int i=arr.length-1; i>0; i--) {
			for (int j=0; j<i; j++) {
				if (arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}

	/**
	 * 打印整型的一维数组
	 */
	private static void print(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
	}

	/**
	 * 打印整型的二维数组
	 */
	private static void print(int[][] arr) {
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private static int count3Quit1(int n) {
		int survival = 0; // 如果人数=1，那么没有必要数了

		// 如果人数>1，才需要执行后面的操作
		if (n != 1) {
			boolean[] arr = new boolean[n];
			for (int i=0; i<arr.length; i++) {
				arr[i] = true;
			}

			int remainder = arr.length;
			int counter = 0;
			int index = 0;

			do {
				if (arr[index] == true) {
					counter++;
					if (counter == 3) {
						counter = 0;
						arr[index] = false;
						remainder--;
					}
				}

				index++;

				if (index == arr.length) {
					index = 0;
				}
			} while (remainder > 1);

			for (int i=0; i<arr.length; i++) {
				if (arr[i] == true) {
					survival = i; 
				}
			}
		}

		return survival;
	}

	/**
	 * 二分法
	 */
	private static int binarySearch(int[] a, int n) {
		if (a.length == 0) {
			return -1;
		}

		int startPos = 0;
		int endPos = a.length - 1;
		int m = (startPos + endPos) / 2;
		while (startPos <= endPos) {
			if (n == a[m]) {
				return m;
			} else if (n > a[m]) {
				startPos = m + 1;
			} else {
				endPos = m - 1;
			}

			m = (startPos + endPos) / 2;
		}

		return -1;
	}
}

class Date {
	private int year;

	private int month;

	private int day;

	Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int compare(Date date) {
		if (year > date.year) {
			return 1;
		} else if (year < date.year) {
			return -1;
		} else if (month > date.month) {
			return 1;
		} else if (month < date.month) {
			return -1;
		} else if (day > date.day) {
			return 1;
		} else if (day < date.day) {
			return -1;
		} else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return "year-month-day: " + year + "-" + month + "-" + day;
	}
}