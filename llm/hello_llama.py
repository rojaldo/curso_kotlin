from llama_index.core import VectorStoreIndex, SimpleDirectoryReader, Settings
from llama_index.embeddings.huggingface import HuggingFaceEmbedding
from llama_index.llms.ollama import Ollama

documents = SimpleDirectoryReader("data").load_data()

# bge-base embedding model
Settings.embed_model = HuggingFaceEmbedding(model_name="BAAI/bge-base-en-v1.5")

# ollama which is in localhost:11434, use llama3.2 model
Settings.llm = Ollama(host="http://localhost:11434", model="llama3.2")

index = VectorStoreIndex.from_documents(
    documents,
)

documents = SimpleDirectoryReader("data").load_data()
index = VectorStoreIndex.from_documents(documents)
query_engine = index.as_query_engine()
response = query_engine.query("list the title of stories that paul graham wrote, answer in spanish")
print(response)