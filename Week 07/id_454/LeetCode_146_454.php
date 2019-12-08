<?php


class LRUCache
{

    protected $capacity;
    protected $stack;
    function __construct($capacity)
    {
        $this->capacity = $capacity;
    }

    function get($key)
    {
        if (!isset($this->stack[$key])) return -1;

        $value = $this->stack[$key];
        unset($this->stack[$key]);
        $this->stack[$key] = $value;

        return $value;
    }

    function put($key, $value)
    {

        if (isset($this->stack[$key])) {
            $this->get($key);
            $this->stack[$key] = $value;
            return null;
        }

        if (count($this->stack) == $this->capacity) {
            reset($this->stack);
            $curr_key = key($this->stack);
            unset($this->stack[$curr_key]);
        }

        $this->stack[$key] = $value;
        return null;
    }
}
