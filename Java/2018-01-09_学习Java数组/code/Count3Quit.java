
/**
 * 智力题（数3退1）的面向对象版本
 * 本质：双向循环列表
 * 
 * @author	Genpeng Xu
 * @date	2018/01/23
 */
public class Count3Quit {
	public static void main(String[] args) {
		KidCircle kc = new KidCircle(500);
		int counter = 0;
		Kid k = kc.first;
		while (kc.count > 1) {
			counter++;
			if (counter == 3) {
				counter = 0;
				kc.delete(k);
			}
			k = k.right;
		}

		System.out.println(kc.first.id);
	}
}

class Kid {
	int id;
	Kid left;
	Kid right;
}

class KidCircle {
	int count = 0;
	Kid first;
	Kid last;

	KidCircle(int n) {
		for (int i=0; i<n; i++) {
			add();
		}
	}

	void add() {
		Kid k = new Kid();
		k.id = count;
		if (count <= 0) {
			first = k;
			last = k;
			k.left = k;
			k.right = k;
		} else {
			first.left = k;
			last.right = k;
			k.left = last;
			k.right = first;
			last = k;
		}
		count++;
	}

	void delete(Kid k) {
		if (count <= 0) {
			return;
		} else if (count == 1) {
			first = last = null;
		} else {
			k.left.right = k.right;
			k.right.left = k.left;

			if (k == first) {
				first = k.right;
			} else if (k == last) {
				last = k.left;
			}
		}
		count--;
	}
}