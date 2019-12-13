class Solution {

    /**
    * @param String $s
    * @return String
    */
    public $temp = "";
    public $count = 0;
    function longestPalindrome($s) {
        $len = strlen( $s );
        if( $len <= 1 ) return $s;
        for( $i = 0; $i < $len; $i++ ){
            $this->diffusion($s,$i,$i);
            $this->diffusion($s,$i,$i+1);
        }
        return $this->temp;
    }
    private function diffusion($s,$left,$right){
        while( $left >= 0 && $right < strlen( $s ) && $s[$left] == $s[$right]){
            if(($right - $left + 1) > $this->count){
                $this->count = $right - $left + 1;
                $this->temp = substr($s,$left,$right-$left+1);
            }
            $left--;
            $right++;
        }
    }

}

