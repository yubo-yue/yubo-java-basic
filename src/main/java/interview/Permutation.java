package interview;

public class Permutation {
	public ListNodeHex addTwoNumbers(ListNodeHex l1, ListNodeHex l2) {
		if (l1 == null || l2 == null) {
			return l2 == null ? l1 : l2;
		}

		// reverse both l1,l2, then we can add each bit from head. finally
		// return reversed result
		ListNodeHex result, hs, h1, h2, pre, next, cur;
		h1 = l1;
		h2 = l2;
		// reverse l1
		if (h1.next != null) {
			cur = h1.next;
			pre = h1;
			pre.next = null;
			while (cur != null) {
				next = cur.next;
				cur.next = pre;
				pre = cur;
				cur = next;
			}
			h1 = pre;
		}
		// reverse l2
		if (h2.next != null) {
			cur = h2.next;
			pre = h2;
			pre.next = null;

			while (cur != null) {
				next = cur.next;
				cur.next = pre;
				pre = cur;
				cur = next;
			}
			h2 = pre;
		}

		// add
		ListNodeHex cur1 = h1;
		ListNodeHex cur2 = h2;
		int prev = 0;
		ListNodeHex r = new ListNodeHex('0');
		hs = r;
		pre = r;
		while (cur1 != null || cur2 != null) {
			// handle cur1 value
			int va = 0;
			if (cur1 != null) {
				if (cur1.val >= 'A' && cur1.val <= 'F') {
					va = 10 + cur1.val - 'A';
				} else if (cur1.val >= 'a' && cur1.val <= 'f') {
					va = 10 + cur1.val - 'a';
				} else if (cur1.val >= '0' && cur1.val <= '9') {
					va = cur1.val - '0';
				}
			}
			// handle cur2 value
			int vb = 0;
			if (cur2 != null) {
				if (cur2.val >= 'A' && cur2.val <= 'F') {
					vb = 10 + cur2.val - 'A';
				} else if (cur2.val >= 'a' && cur2.val <= 'f') {
					vb = 10 + cur2.val - 'a';
				} else if (cur2.val >= '0' && cur2.val <= '9') {
					vb = cur2.val - '0';
				}
			}

			int v = va + vb + prev;
			prev = v / 16;
			r.next = new ListNodeHex('0');
			v %= 16;
			if (v < 10) {
				r.val = (char) ((int) '0' + v);
			} else {
				r.val = (char) ((int) 'A' + v - 10);
			}
			pre = r;
			r = r.next;
			cur1 = (cur1 == null) ? null : cur1.next;
			cur2 = (cur2 == null) ? null : cur2.next;
		}
		if (prev != 0) {
			// only possible is 1 here
			r.val = (char) ((int) '0' + prev);
		} else {
			pre.next = null;
		}

		// reverse
		result = hs;
		if (result.next != null) {
			cur = result.next;
			pre = result;
			pre.next = null;

			while (cur != null) {
				next = cur.next;
				cur.next = pre;
				pre = cur;
				cur = next;
			}
			result = pre;
		}
		return result;
	}
	
	public static class ListNodeHex {
        char val;
        ListNodeHex next;
        ListNodeHex(char x) {
        val = x;
        next = null;
        }
	}


	public static void main(String[] args) {
	}
}