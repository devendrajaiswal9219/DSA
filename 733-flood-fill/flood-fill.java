class Solution {
    public void dfs(int[][] image,int i,int j,int color,int newcolor){
        if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j]!=color){
            return;
        }
        image[i][j]=newcolor;
        dfs(image,i-1,j,color,newcolor);
        dfs(image,i+1,j,color,newcolor);
        dfs(image,i,j-1,color,newcolor);
        dfs(image,i,j+1,color,newcolor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color){
        int oldcolor=image[sr][sc];
        if(oldcolor==color){
            return image;
        }
        dfs(image,sr,sc,oldcolor,color);
        return image;
    }
}