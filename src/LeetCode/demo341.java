package LeetCode;

import java.util.Iterator;
import java.util.List;
//扁平化嵌套列表迭代器
public class demo341 {
//    public class NestedIterator implements Iterator<Integer> {
//        private List<Integer> vals;
//        private Iterator<Integer> cur;
//
//        public NestedIterator(List<NestedInteger> nestedList) {
//            vals = new ArrayList<Integer>();
//            dfs(nestedList);
//            cur = vals.iterator();
//        }
//
//        @Override
//        public Integer next() {
//            return cur.next();
//        }
//
//        @Override
//        public boolean hasNext() {
//            return cur.hasNext();
//        }
//
//        private void dfs(List<NestedInteger> nestedList) {
//            for (NestedInteger nest : nestedList) {
//                if (nest.isInteger()) {
//                    vals.add(nest.getInteger());
//                } else {
//                    dfs(nest.getList());
//                }
//            }
//        }
//    }
}