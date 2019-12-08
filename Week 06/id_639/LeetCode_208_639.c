
typedef struct {
    struct Trie *subs[27];
    char letters[27];
} Trie;

/** Initialize your data structure here. */

Trie* trieCreate() {
    Trie *obj = malloc(sizeof(*obj));
    memset(obj->letters, 0xff, sizeof(obj->letters));
    memset(&obj->subs[0], 0, sizeof(obj->subs));
    return obj;
}

/** Inserts a word into the trie. */
void trieInsert(Trie* obj, char * word) {
    while (*word != '\0') {
        int pos = *word - 'a' + 1;
        obj->letters[pos] = *word++;
        if (obj->subs[pos] == NULL) {
            obj->subs[pos] = trieCreate();
        }
        obj = obj->subs[pos];
    }
    obj->letters[0] = '\0';
}

/** Returns if the word is in the trie. */
bool trieSearch(Trie* obj, char * word) {
   while (obj != NULL) {
        int pos = *word == '\0' ? 0 : *word - 'a' + 1;
        if (obj->letters[pos] != *word) {
            return false;
        }
        word++;
        obj = obj->subs[pos];
    }
    return true;
}

/** Returns if there is any word in the trie that starts with the given prefix. */
bool trieStartsWith(Trie* obj, char * prefix) {
    while (*prefix != '\0') {
        int pos = *prefix - 'a' + 1;
        if (pos < 0 || obj->letters[pos] != *prefix) {
            return false;
        }
        if (*++prefix != '\0') {
            if (obj->subs[pos] == NULL) {
                return false;
            }
            obj = obj->subs[pos];
        }
    }
    return true;
}

void trieFree(Trie* obj) {
  
   int i;
    for (i = 0; i < sizeof(obj->letters); i++) {
        if (obj->subs[i] != NULL) {
            trieFree(obj->subs[i]);
        }
    }
    free(obj);
}

/**
 * Your Trie struct will be instantiated and called as such:
 * Trie* obj = trieCreate();
 * trieInsert(obj, word);
 
 * bool param_2 = trieSearch(obj, word);
 
 * bool param_3 = trieStartsWith(obj, prefix);
 
 * trieFree(obj);
*/
