
from langchain.embeddings import HuggingFaceEmbeddings
from llama_index.embeddings.langchain import LangchainEmbedding

lc_embed_model = HuggingFaceEmbeddings(
    model_name="sentence-transformers/all-mpnet-base-v2"
)
embed_model = LangchainEmbedding(lc_embed_model)


# Basic embedding example
embeddings = embed_model.get_text_embedding(
    "It is raining cats and dogs here!"
)
print(len(embeddings), embeddings[:10])