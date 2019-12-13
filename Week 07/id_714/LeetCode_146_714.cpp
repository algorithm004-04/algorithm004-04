class LinkListNode
{
public:
  LinkListNode() {}
  int key = 0;
  int num = 0;
  LinkListNode *prev = NULL, *next = NULL;
};

class LRUCache
{
public:
  LRUCache(int capacity)
  {
    head_ = new LinkListNode();
    end_ = new LinkListNode();
    head_->next = end_;
    end_->prev = head_;
    max_list_length_ = capacity;
  }

  ~LRUCache()
  {
    LinkListNode *node = head_->next;
    LinkListNode *cur_node = NULL;
    while (node != end_)
    {
      cur_node = node;
      node = node->next;
      delete cur_node;
    }
    delete head_;
    delete end_;
    head_ = NULL;
    end_ = NULL;
  }

  int get(int key)
  {
    auto search = hash_map_.find(key);
    if (search == hash_map_.end())
    {
      return -1;
    }
    LinkListNode *node = search->second;
    LinkListNode *prev = node->prev;
    LinkListNode *next = node->next;
    prev->next = next;
    next->prev = prev;
    AddNode2Head(node, false);
    return search->second->num;
  }

  void put(int key, int value)
  {
    auto search = hash_map_.find(key);
    if (search == hash_map_.end())
    {
      // 判断当前list长度，长度足够就直接加到list head，不够就踢掉list end
      LinkListNode *node = new LinkListNode();
      node->num = value;
      node->key = key;
      if (list_length_ == max_list_length_)
      {
        LinkListNode *del_node = DelNodeFromEnd();
        if (del_node)
        {
          auto end_node_search = hash_map_.find(del_node->key);
          if (end_node_search != hash_map_.end())
          {
            hash_map_.erase(end_node_search);
          }
          delete del_node;
        }
      }
      AddNode2Head(node);
      hash_map_[key] = node;
    }
    else
    {
      search->second->num = value;
      // 调整这个node到head的位置
      LinkListNode *prev = search->second->prev;
      LinkListNode *next = search->second->next;
      prev->next = next;
      next->prev = prev;
      AddNode2Head(search->second, false);
    }
  }

private:
  LinkListNode *head_ = NULL, *end_ = NULL;
  int list_length_ = 0;
  int max_list_length_ = 0;
  unordered_map<int, LinkListNode *> hash_map_;

  void AddNode2Head(LinkListNode *node, bool add_list_length = true)
  {
    if (!node)
      return;
    LinkListNode *next_node = head_->next;
    head_->next = node;
    node->prev = head_;
    node->next = next_node;
    next_node->prev = node;
    if (add_list_length)
    {
      list_length_++;
    }
  }

  LinkListNode *DelNodeFromEnd()
  {
    LinkListNode *last_node = end_->prev;
    if (last_node != head_)
    {
      LinkListNode *last_last_node = last_node->prev;
      last_last_node->next = end_;
      end_->prev = last_last_node;
      list_length_--;
      return last_node;
    }
    return NULL;
  }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */