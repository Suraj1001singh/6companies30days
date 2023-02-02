
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        if (mountainArr.get(peak) == target)// if peak is the target
            return peak;
        int left = binarySearch(mountainArr, target, false, 0, peak - 1);
        if (left != -1)
            return left;
        else
            return binarySearch(mountainArr, target, true, peak + 1, mountainArr.length() - 1);
    }

    public int binarySearch(MountainArray ma, int target, boolean isRev, int l, int h) {
        int pos = -1;
        if (!isRev) {// sorted in ascending order
            while (l <= h) {
                int mid = (l + h) / 2;
                int a = ma.get(mid);
                if (a < target)
                    l = mid + 1;
                else if (a > target)
                    h = mid - 1;
                else {
                    pos = mid;
                    h = mid - 1;
                }
            }
        } else { // sorted in descending order
            while (l <= h) {
                int mid = (l + h) / 2;
                int a = ma.get(mid);
                if (a < target)
                    h = mid - 1;
                else if (a > target)
                    l = mid + 1;
                else {
                    pos = mid;
                    h = mid - 1;
                }
            }
        }

        return pos;
    }

    public int findPeak(MountainArray ma) {
        int len = ma.length();
        int l = 0;
        int h = len - 1;
        while (l < h) {
            int mid = (l + h) / 2;
            int a = ma.get(mid);
            int b = mid - 1 >= 0 ? ma.get(mid - 1) : -1;
            int c = mid + 1 < len ? ma.get(mid + 1) : -1;

            if (a > b && a > c)
                return mid;
            else if (b < a && a < c)
                l = mid + 1;
            else
                h = mid - 1;

        }
        return -1;

    }
}

interface MountainArray {
    public int get(int index) {}

    public int length() {}
}
