from ollama import Client
from ollama import chat
from itertools import chain


client = Client(
  host='http://localhost:11434',
  headers={'x-some-header': 'some-value'}
)

# response = client.chat(model='llama3.2', messages=[
#   {
#     'role': 'user',
#     'content': 'Why is the sky blue?',
#   },
# ])

# print(response['message']['content'])

# messages = [
#   {
#     'role': 'user',
#     'content': 'Why is the sky blue?',
#   },
# ]

# for part in client.chat('llama3.2', messages=messages, stream=True):
#   print(part['message']['content'], end='', flush=True)

# print()

def flatten_list(nested_list):
    return list(chain.from_iterable(nested_list))

response = client.embed(model='llama3.2', input='mother')
vector_1 = flatten_list(response['embeddings'])
response = client.embed(model='llama3.2', input='father')
vector_2 = flatten_list(response['embeddings'])
response = client.embed(model='llama3.2', input='male')
vector_3 = flatten_list(response['embeddings'])
response = client.embed(model='llama3.2', input='female')
vector_4 = flatten_list(response['embeddings'])



# a function to calculate the cosine similarity between two vectors
def cosine_similarity(a, b):
    dot_product = sum(i * j for i, j in zip(a, b))
    magnitude_a = sum(i ** 2 for i in a) ** 0.5
    magnitude_b = sum(i ** 2 for i in b) ** 0.5
    if magnitude_a == 0 or magnitude_b == 0:
        return 0.0
    return dot_product / (magnitude_a * magnitude_b)

print(cosine_similarity(vector_1, vector_2))