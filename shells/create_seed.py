import pandas as pd
from os import walk, path
from typing import List
from uuid import uuid4

DATAS_PATH = './datas'
GIDO_SUFFIX = 'gido'


def enumerate_files(directory: str) -> List[str]:
    file_list = []

    for (_, _, filenames) in walk(directory):
        dir_joined_list = [path.join(directory, filename) for filename in filenames]
        file_list.extend(dir_joined_list)
        break
    
    return file_list


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


for file in enumerate_files(DATAS_PATH):
    if GIDO_SUFFIX not in file:
        continue
    
    json_dict = pd.read_json(file)
    
    author = json_dict["Text"][0]
    
    texts = list(set(json_dict["Embedded_text"]))[0:1000]
    
    print(format_insert_sqls(author, texts))
