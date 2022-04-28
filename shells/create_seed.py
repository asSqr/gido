import pandas as pd
from os import walk, path
from typing import List
from uuid import uuid4

DATAS_PATH = './datas'


def format_insert_sqls(author: str, texts: List[str]) -> str:
    ret_str = ''
    used_text = {}
    
    for text in texts:
        if text[0:140] in used_text:
            continue
        
        uuid = str(uuid4())
        ret_str += f"INSERT INTO M_SENTENCE VALUES({uuid!r}, {author!r}, {text!r});\n"
        used_text[text[0:140]] = True
    
    return ret_str


file_list = []

for (dirpath, dirnames, filenames) in walk(DATAS_PATH):
    file_list.extend(filenames)
    
    break

for file in file_list:
    json_dict = pd.read_json(path.join(DATAS_PATH, file))
    
    author = json_dict["Text"][0]
    
    texts = list(set(json_dict["Embedded_text"]))
    
    print(format_insert_sqls(author, texts))
